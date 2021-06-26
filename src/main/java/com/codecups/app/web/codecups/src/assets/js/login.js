window.onload=function(){
  const signUpButton = document.getElementById('signUp');
  const signInButton = document.getElementById('signIn');
  const container = document.getElementById('container');

  signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
    window.history.pushState("dsad", "test", "v0/register")
  });

  signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
    window.history.pushState("dsad", "test", "v0/login")
  });
}

