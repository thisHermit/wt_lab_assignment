function validation(){
  var name = document.getElementById("uname").value;
  var password = document.getElementById("psw").value;
  console.log(name);
  console.log(password);
  if( name === 'user' && password === '123'){
    alert("Authenticated Successfully");
  } else {
    alert("NOTTT")
  }
}
