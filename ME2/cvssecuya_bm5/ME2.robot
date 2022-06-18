*** Settings ***
Library    RemoteSwingLibrary

*** Test Cases ***
Start Game Application
    Start Application   my_app	java -jar ME2.jar
Select the main window
	Select Window 	mainWindow 
1A Check if radio button A1 is selected
    Select From Main Menu   Options|Start Game
	Radio Button Should Be Selected 	buttonA1
1B All radio buttons shall be visible
    Component Should Be Visible   buttonA1  
    Component Should Be Visible   buttonA2
    Component Should Be Visible   buttonA3
    Component Should Be Visible   buttonB1   
    Component Should Be Visible   buttonB2
    Component Should Be Visible   buttonB3
    Component Should Be Visible   buttonC1
    Component Should Be Visible   buttonC2
    Component Should Be Visible   buttonC3  
#1C The theme should be Light - to be checked manually
1D Score shall be 0
    Label Text Should Be    scoreValue  0
2 Exit window when clicked submenu
    Ensure Application Should Close     5 seconds   Select From Main Menu   Options|Exit 
3 Pop up dialog should appear when user selects Options->Theme
    Start Application   my_app	java -jar ME2.jar
    Select Window 	mainWindow
    Select From Menu And Wait   Options|Theme
3A The title of the dialog should be Theme
    Dialog Should Be Open  Theme
    Select Dialog   Theme
3B There should be a combobox with the options Light and Dark
    ${themes}     Get Combobox Values     themeOptions
    Should Contain      ${themes}   Light
    Should Contain      ${themes}   Dark
    Close Dialog    Theme
#4. When Light theme is selected: the matrix background should be white - to be checked manually
#5. When Dark theme is selected: the matrix background should be black - to be checked manually
6. When a user clicks Help->How to play, a pop up window shall appear 
    Select Window   mainWindow
    Select From Menu And Wait   Help|How to play
6A. The title should be Game instructions  
    Dialog Should Be Open  Game instructions
    Select Dialog   Game instructions
6B. The content as The user shall reach the end of the maze by using the arrow controls or mouse clicks.
    Component Should Exist  howToPlayLabel 
    Label Text Should Be    howToPlayLabel  The user shall reach the end of the maze by using the arrow controls or mouse clicks.
    Close Dialog    Game instructions
7. When a user clicks Help->About this game, a pop up window
    Select Window   mainWindow
    Select From Menu And Wait   Help|About this game
7A. The title should be About     
    Dialog Should Be Open  About
    Select Dialog   About
7B. The content should be A simple game with Action and Item Listeners.
    Component Should Exist  aboutLabel 
    Label Text Should Be    aboutLabel  A simple game with Action and Item Listeners.
    Close Dialog    About
8. When a user clicks the left arrow button, the left radio button of the current one shall be selected. 
    Select Window   mainWindow
    Push Radio Button   buttonA2
    Push Button     left
    Radio Button Should Be Selected     buttonA1
9. When a user clicks the up arrow button, the top radio button of the current one shall be selected. 
    Select Window   mainWindow
    Push Radio Button   buttonB1
    Push Button     up
    Radio Button Should Be Selected     buttonA1
10. When a user clicks the down arrow button, the bottom radio button of the current one shall be selected. 
    Select Window   mainWindow
    Push Radio Button   buttonA1
    Push Button     down
    Radio Button Should Be Selected     buttonB1
11. When a user clicks the right arrow button, the right radio button of the current one shall be selected. 
    Select Window   mainWindow
    Push Radio Button   buttonA1
    Push Button     right
    Radio Button Should Be Selected     buttonA2
#12A. When the selected radio button changes, the previously selected radio button shall not be visible - to be checked manually
#    Select Window   mainWindow
#    Push Radio Button   buttonA1
#    Push Radio Button   buttonA2
#    Component Should Not Be Visible     buttonA1
12B. When the selected radio button changes, the score shall increment by 10
    Select From Main Menu   Options|Start Game
    Push Radio Button   buttonA2
    Label Text Should Be    scoreValue      10
13. When the radio button in position C3 is reached, a pop-up dialog shall appear
    Push Radio Button   buttonC3
13A. Title should be Congratulations
    Dialog Should Be Open  Congratulations
    Select Dialog   Congratulations
13B. The content should be You Win!
    Component Should Exist  congratsLabel 
    Label Text Should Be    congratsLabel  You Win!
    Close Dialog    Congratulations

*** Keywords ***