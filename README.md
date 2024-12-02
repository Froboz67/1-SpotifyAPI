# Spotify API Services Experimentation
​
This is a full stack application
It utilizes the [spotify-web-api-java library](https://github.com/spotify-web-api-java/spotify-web-api-java)

It is the result of a continuing education course I am taking. We started out with a simple get Artist method, and I grew the code a bit more. I can currently display pertinent artist information (images, genres, etc) from a search query. I have also added a search query for Albums which will display important facts about an album (title, image, tracks, record label, recording date, etc)

## Personal gains from this project

I learned specifically about the CSS clamp() function which allows text to dynamically change though the resizing of the web browser window. This was a great find as it allows my application to have a smooth and dynamic flow while keeping text sizing relative to the size of the browser window. It is especially effective for mobile applications.

font-size: clamp(1rem, 2vw, 2rem);
/* the first parameter is the min font size
  the second param is the responsive size for dynamic text based on screen size 
  third param is the max font size */
  

I plan to continue building and styling this application over time.
