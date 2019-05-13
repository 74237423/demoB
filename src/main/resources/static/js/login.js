
(function () {
  const loginBtn = document.getElementById('login-btn');
  
  loginBtn.addEventListener('click', function () {
      let id = document.getElementById('id').value;
      let password = document.getElementById('password').value;
      let args = 'id=' + encodeURIComponent(id) + '&password=' + encodeURIComponent(password);

      axios.post('/login.do', {
          id: id,
          password: password
      }).then(function (response) {
          if (response.data) {
            console.log(response.data);
            window.location = '/coursepage?stuId=' + id;
          }

      }).catch(function (error) {
          console.log(error)
      });
  })
  
})();