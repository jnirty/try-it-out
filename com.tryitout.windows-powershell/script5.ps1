$strComputer = "."
$colItems = get-wmiobject -class "Win32_Processor" -namespace "root\CIMV2" -computername $strComputer
foreach ($objItem in $colItems) {
write-host "Caption: " $objItem.Caption
write-host "CPU Status: " $objItem.CpuStatus
write-host "Current Clock Speed: " $objItem.CurrentClockSpeed
write-host "Device ID: " $objItem.DeviceID
write-host "L2 Cache Size: " $objItem.L2CacheSize
write-host "L2 Cache Speed: " $objItem.L2CacheSpeed
write-host "Name: " $objItem.Name
write-host
}