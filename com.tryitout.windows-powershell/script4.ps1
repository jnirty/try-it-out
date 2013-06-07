#launches Notepad
Notepad
#Setup a do while loop that does nothing while property value is True.
do {}
While (get-process notepad | select -Property Responding)
#Code to run when loop stops (when notepad is closed)
$strTime = get-date
Write-Host "The Application Notepad failed to respond on: $strTime"