

set mysqldump="C:\Program Files (x86)\MySQL\MySQL Server 5.7\bin\mysqldump.exe"
set base="sinapsis"
%mysqldump% --user=root --password=root --add-drop-database  --databases %base% > %1