swig -c++ -java -package com.itqy8.ctp -outdir javacode ctp.i
g++ -c -fpic ctp_wrap.cxx -I/usr/java/jdk1.8.0_92/include -I/usr/java/jdk1.8.0_92/include/linux/
sudo cp ctp/thostmduserapi.so /usr/lib/libthostmduserapi.so
sudo cp ctp/thosttraderapi.so /usr/lib/libthosttraderapi.so
g++ -shared ctp_wrap.o -lthostmduserapi -o libmdctp.so
g++ -shared ctp_wrap.o -lthosttraderapi -o libtraderctp.so
sudo cp libmdctp.so /usr/lib
sudo cp libtraderctp.so /usr/lib
sudo ldconfig
