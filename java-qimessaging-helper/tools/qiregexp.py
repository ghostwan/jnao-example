
import sys
import re
import subprocess

QIRE = re.compile(r"\s*\d+\s+(\w+)\s+(.*)\s+\((.*)\)")
INFO = re.compile(r"\s*\d+\s+\[(.*)\]")

TEMPLATE_VOID = """public %(outtype)s %(method)s(%(args)s) throws CallError, InterruptedException{
      if (isAsynchronous)
        service.call("%(method)s"%(extraparams)s);
      else
        service.call("%(method)s"%(extraparams)s).get();
}"""

TEMPLATE_RETURN = """public %(outtype)s %(method)s(%(args)s) throws CallError, InterruptedException {
      return (%(outtype)s)service.call("%(method)s"%(extraparams)s).get();
}"""

JTYPES = {"Void": "void", "Bool": "Boolean", "Value": "Object", "UInt32":"Integer", "Int32":"Integer",  
"Unknown":"Object", "PackageInfo":"Object", "ProcessInfo":"Object", "ObjectStatus" : "Object", "PartitionInfo":"Object" , "ServiceInfo" : "Object",
"LogMessage":"Object", "List<String,Integer>" : "Map<String,Integer>"}

TEMPLATE_CLASS = """package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;
import java.util.List;
import java.util.Map;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class %(module_name)s extends ALModule {

    public %(module_name)s(Session session) {
        super(session);
    }

    %(content)s
}
    """
ALMEMORY_BUG = """public void addMapping(String param1, Map<String param2, String> param3) throws CallError, InterruptedException{
          service.call("addMapping", param1, param2, param3).get();
    }"""
ALMEMORY_FIX = """public void addMapping(String param1, Map<String,String> param2) throws CallError, InterruptedException{
          service.call("addMapping", param1, param2).get();
    }"""

def qicli_info():
  outputQicliInfo = subprocess.check_output(["qicli", "info"])
  
  for line in outputQicliInfo.split("\n") :
    m = INFO.match(line)
    if m:
      module = m.group(1)
      print module
      print_sys_input(module)

def qicli_info_method(module):
  output = subprocess.check_output(["qicli", "info",  module, "--show-doc"])
  return output.split("\n")

def print_sys_input(module):
  content = ""
  result = qicli_info_method(module)
  for chunk in interpret_qicli(result):
    for line in chunk.split("\n"):
      content += "    %s\n" % line
  module_name = module
  result = TEMPLATE_CLASS % locals()

  if module == "ALMemory" :
    result = result.replace(ALMEMORY_BUG, ALMEMORY_FIX)

  if "preview" in sys.argv:
    print result
  
  with open(module_name + ".java", "w") as outfile:
    outfile.write(result)
    outfile.close()


def interpret_qicli(from_qicli):
  last_method = None
  doclines = []
  def flush():
    if last_method:
      yield "/** "
      for docline in doclines:
        yield " *" + docline
      yield " */"
      yield last_method
      yield ""
    del doclines[:]
  for line in from_qicli:
    line = line.strip("\n")
    if line:
      output = read_qidoc(line)
      if output:
        for chunk in flush():
          yield chunk
        last_method = output
        #return # temp
      #yield "DBG ADDING " + line + " TO " + repr(doclines)
      doclines.append(line)
  for chunk in flush():
    yield chunk

def interpret_type(qitype) :
  #qitype = JTYPES.get(qitype, qitype)
  qitype = qitype.replace("(","")
  qitype = qitype.replace(")","")
  for key, value in JTYPES.items() :
    if qitype == "UInt32" :
      qitype = "Integer"
    elif qitype == "Object" :
      qitype = "com.aldebaran.qimessaging.Object"
    else :
      qitype = qitype.replace(key,value)
  return qitype

def read_qidoc(command):
    m = QIRE.match(command)
    if m:
      method, outtype, intypes = m.groups()
      
      outtype = interpret_type(outtype)
      if not outtype :
        outtype = "void"

      if method == "package" :
        method = "qiPackage"
      argslist = []
      extraparams = ""
      if intypes:
          for i, intype in enumerate(intypes.split(",")):
              parami = "param%i" % (i + 1)
              argslist.append(interpret_type(intype) + " " + parami)
              extraparams += ", " + parami
      args = ", ".join(argslist) 
      if outtype == "void":
        return TEMPLATE_VOID % locals()
      else :
        return TEMPLATE_RETURN % locals()

def run_test():
    successes = 0
    trials = 0
    for line in IN:
        output = read_qidoc(line)
        print "%s" % output        
    print
    print "successes: %i/%i" % (successes, trials)

if __name__ == "__main__":
    #run_test()
    qicli_info()
    #print_sys_input("ALMotion")
