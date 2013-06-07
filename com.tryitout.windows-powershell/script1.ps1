# tutorial at: http://www.powershellpro.com/powershell-tutorial-introduction

$strA = "Hello "
$strB = "World!"
$strC = $strA += $strB
$strC

$strA = "Go east young man!"
$strB = $strA -replace "east", "west"
$strB

# lists
$strComputers = @("Server1", "Server2", "Server3")
$strComputers

$strComputers -contains "Server1"

$strComputers[0]

$x = @(1, 2, 3, 4, 5)
$y = @(6, 7, 8, 9, 10)
$z = $x + $y
$z

# maps:
$EmpNumbers = @{"John Doe" = 112233; "Dave Davis" = 223344; "Justine Smith" = 334455}

$EmpNumbers.Remove("Dave Davis")
$EmpNumbers| Get-Member

7 -eq 7
"tom" -eq "Tom"
"tom" -ieq "Tom"
"tom" -ceq "Tom"


$x = 2 #creates a variable x and assigns 2 as the value
  if ($x -eq 5) {Write-Host "Hello my name is Bob"}
    elseif ($x -eq 4) {Write-Host "Hello, my name is Sue"}
    elseif ($x -eq 2) {Write-Host "Hello, my name is Troy"}
    elseif ($x -gt 1) {Write-Host "Hello, my name is Mary"}
  else {"I have no idea what my name is?"}
  
$i = 1
do {Write-Host $i; $i++}
while ($i -le 5)
  
Get-WmiObject -List | where {$_ -match "test"}

for ($i=1; $i -le 5; $i++)
{Write-Host $i}

for ($i=1
$i -le 5
$i++)
{write-host $i}

$ints = @(1, 2, 3, 4, 5)
foreach ($i in $ints)
{Write-Host $i}

ls | where {$_.Name -like "*.ps1"}