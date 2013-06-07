# implement function
Function Time {Get-Date}
Function Add ($x, $y)
{
	$Ans = $x + $y
	Write-Host "The Answer is $Ans"
}
Function HAL {"What are you doing $args ?"}
Function FindFolder
{
	$input | Where-Object {$_.Name -eq "Windows"}
}

# invoke function
Time
Add 1 2
Add 1 "text"
HAL "Marcin" "Adam"

Get-ChildItem -Path C:\ | FindFolder