document.addEventListener("DOMContentLoaded", function () {
  document.querySelectorAll(".btn-logout").forEach(function (btn) {
    btn.addEventListener("click", function () {
      sessionStorage.clear();
      window.location.href = "/findJobFrontEnd/index.html";
    });
  });
});
