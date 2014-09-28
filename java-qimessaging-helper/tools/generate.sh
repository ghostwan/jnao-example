#!/bin/sh

sshpass -p "nao" ssh nao@$1 "mkdir al"
sshpass -p "nao" scp qiregexp.py nao@$1:~/al/
sshpass -p "nao" ssh nao@$1 "cd al && python qiregexp.py"
sshpass -p "nao" scp -r nao@$1:~/al .
sshpass -p "nao" ssh nao@$1 "rm -rf al"
