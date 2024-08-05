console.log("script loaded: ");

//change theme work
let currentTheme = getTheme();
//initial

document.addEventListener('DOMContentLoaded',() => {
    changeTheme();
})



//TODO:
function changeTheme(){
//set to web page

changePageTheme(currentTheme, "");

}
 //set the listner to change theme button

 const changeThemeButton = document.querySelector('#theme_change_button');

//get the current theme


changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    
    console.log("change theme button Clicked: ");
    
    if(currentTheme === "dark"){
        //theme to light mode
        currentTheme = "light";
    }
    else if(currentTheme === "light"){
        //theme to dark mode
        currentTheme = "dark";
        }

        changePageTheme(currentTheme, oldTheme);
        
});
function setTheme(theme){
localStorage.setItem("theme", theme);
}

function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}
//change current page theme
function changePageTheme(theme,oldTheme){
    //update the theme in localstorage 
    setTheme(currentTheme);
    //remove the current theme
    if(oldTheme){
        document.querySelector('html').classList.remove(oldTheme);
    }
    //set the cuurrent theme
    document.querySelector('html').classList.add(theme);

    //change the text of button
      document.querySelector('#theme_change_button').querySelector('span').textContent = theme == "light"? "dark":"light";
}
//change page theme end