 
## [Easy] Assignment #1

Each morning, you wake up to the sound of birds. 
Over time, you’ve noticed three unique bird sounds, each repeating at a different pace. 
One bird makes a sound every second, the other every 2 seconds, and the last every 3 seconds.

Instructions

Recreate the timing of each bird’s sounds using a single coroutine for each bird. 
Each coroutine should only print four times before completing.

* The first bird makes a “Coo” sound.
* The second bird makes a “Caw” sound.
* The last bird makes a “Chirp” sound.

## [Medium] Assignment #2

Once woken up by the birds, you enjoy listening to them for a while. 
Afterward, you must prepare for the day, so after listening to the birds for a while, you close your window and get ready.

Instructions

Extend the previous assignment by removing the limitation of only printing four times to the console; 
each coroutine can print indefinitely now. Add a mechanism to cancel all running coroutines after 10 seconds.

## [Hard] Assignment #3

You decide to make a simple mobile application to simulate the birds’ sounds you hear in the morning. 
After planning, you’ve decided on a single screen with three buttons. Each button will show the bird's name on the screen and print its sound to the console. Tapping a new button will replace the previous bird's name on the screen, and only the new bird’s sounds will print to the console.

Instructions

Create a single-screen app using coroutines in Compose. Add three buttons, each representing a different bird. Create a composable function for each bird that displays the bird’s name and launches a coroutine to print the bird's sound to the console. Only render the composable of the bird represented by the last button tapped and ensure only the selected bird's sounds are printed.