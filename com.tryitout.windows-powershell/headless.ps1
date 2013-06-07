# Running headless process
write-host "Starting headless process ..." -foregroundcolor "magenta" -backgroundcolor "blue"
start-process notepad -WindowStyle Hidden

write-host "Check process started" -foregroundcolor "magenta" -backgroundcolor "blue"
Get-Process -Name notepad

write-host "Stop process" -foregroundcolor "magenta" -backgroundcolor "blue"
Stop-Process -Name notepad

write-host "Check if process stopped" -foregroundcolor "magenta" -backgroundcolor "blue"
Get-Process -Name notepad