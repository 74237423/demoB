
(function () {
  const loginBtn = document.getElementById('login-btn');

  console.log('here');
  loginBtn.addEventListener('click', function () {
      let id = document.getElementById('id').value;
      let password = document.getElementById('password').value;
      //id = encodeURIComponent(id);
      //password = encodeURIComponent(password);

      console.log(id);
      console.log(password);
      axios.post('/login?id=' + id + '&password=' + password)
          .then(function (response) {
              console.log(response);
              if (response.data) {
                  window.location = '/coursepage?stuId=' + id;
              } else {
                  alert('用户名或密码错误');
              }
          })
          .catch(function (error) {
              console.log(error);
          });

  });

})();