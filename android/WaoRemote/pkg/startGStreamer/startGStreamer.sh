#!/bin/sh

gst-launch-0.10 -v v4l2src device=/dev/video0 ! video/x-raw-yuv,width=640,height=480,framerate=30/1 ! ffmpegcolorspace ! jpegenc ! multipartmux! tcpserversink port=3000