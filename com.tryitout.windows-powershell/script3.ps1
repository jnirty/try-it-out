# ivoke it with full path like: C:\dev\PowerShell\script3.ps1 or like: .{.\script3.ps1}
$strComputer = Read-Host "Printer Report – Enter Computer Name"
$OS = Get-WmiObject -Class win32_OperatingSystem -namespace "root\CIMV2" `
-ComputerName $strComputer
# if statement to run code for Windows XP and Windows 2003 Server.
if (($OS.Version -eq "6.1.7601") -or ($OS.Version -eq "5.2.3790"))
{
    write-host "Computer Name: " $strComputer
    #nested if statement
    if ($OS.Version -eq "6.1.7601") {write-host "OS Version: Windows 7"}
    elseif ($OS.Version -eq "5.2.3790") {write-host "OS Version: Windows 2003"}
        $colPrinters = Get-WmiObject -Class win32_Printer -namespace "root\CIMV2" `
        -computerName $strComputer
            foreach ($objPrinter in $colPrinters) {
            write-host "Name: " $objPrinter.Name
            write-host "Description: " $objPrinter.Description
            write-host
            }
}
# if statement to run code for Windows 2000 Server
elseif ($OS.Version -eq "5.0.2195")
{
    write-host "Computer Name: " $strComputer
    write-host "OS Version: Windows 2000 Server"
        $colPrinters = Get-WmiObject -Class win32_PrintJob -namespace "root\CIMV2" `
        -computername $strComputer
        foreach ($objPrinter in $colPrinters) {
        write-host "Name: " $objPrinter.Name
        write-host "Description: " $objPrinter.Description
        write-host
        }
}
# if OS not identified
else {write-host "The OS for: $strComputer is not supported."}
write-host "–END OF REPORT–"