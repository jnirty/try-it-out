create tablespace MYSPACE
  logging
  datafile 'C:\TOOLS\ORACLEXE112_WIN32\APP\ORACLE\ORADATA\XE\MYSPACE.DBF' 
  size 32m 
  autoextend on 
  next 32m maxsize 2048m
  extent management local;
  commit
