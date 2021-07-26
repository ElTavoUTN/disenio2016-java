set mysql="C:\Program Files (x86)\MySQL\MySQL Server 5.7\bin\mysql.exe"
set base="sinapsis"

%mysql% --user=root --password=root %base% < %1
