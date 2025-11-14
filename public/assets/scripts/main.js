document.addEventListener("DOMContentLoaded", () => {
  const isLoggedIn = localStorage.getItem("loggedIn") === "true";
  const isLoginPage = window.location.pathname.includes("index.html");

  if (!isLoggedIn && !isLoginPage) {
    window.location.href = "/Grupo2-IHC/index.html";
    return;
  }

  if (isLoggedIn && isLoginPage) {
    window.location.href = "./assets/pages/dashboard.html";
    return;
  }

  function showModal(templateId) {
    const template = document.getElementById(templateId);
    const clone = template.content.cloneNode(true);
    document.body.appendChild(clone);

    const modalId = templateId.replace("Template", "Modal");
    const modal = document.getElementById(modalId);
    modal.style.display = "block";

    if (templateId === "loginTemplate") handleLogin(modal);
    if (templateId === "registerTemplate") handleRegister(modal);

    modal.querySelector(".close").addEventListener("click", () => {
      modal.remove();
    });

    window.addEventListener("click", function handler(e) {
      if (e.target === modal) {
        modal.remove();
        window.removeEventListener("click", handler);
      }
    });
  }

  function handleRegister(modal) {
    const btn = modal.querySelector("button");
    btn.addEventListener("click", () => {
      const email = modal.querySelector('input[type="email"]').value;
      const password = modal.querySelector('input[type="password"]').value;
      const name = modal.querySelector('input[type="text"]').value;

      if (!email || !password || !name) {
        alert("Por favor completa todos los campos.");
        return;
      }

      const users = JSON.parse(localStorage.getItem("users")) || {};
      if (users[email]) {
        alert("El usuario ya está registrado.");
        return;
      }

      users[email] = { password, name };
      localStorage.setItem("users", JSON.stringify(users));
      alert("Registro exitoso.");
      modal.remove();
    });
  }

  function handleLogin(modal) {
    const btn = modal.querySelector("button");
    btn.addEventListener("click", () => {
      const email = modal.querySelector('input[type="text"]').value;
      const password = modal.querySelector('input[type="password"]').value;
      const users = JSON.parse(localStorage.getItem("users")) || {};

      if (users[email] && users[email].password === password) {
        alert(`¡Bienvenido, ${users[email].name}! Has iniciado sesión correctamente.`);
        localStorage.setItem("loggedIn", "true");
        modal.remove();
        window.location.href = "./assets/pages/dashboard.html";
      } else {
        alert("Correo o contraseña incorrectos.");
      }
    });
  }

  document.querySelectorAll('a[href="#login"], .btn.tertiary').forEach((btn) => {
    btn.addEventListener("click", (e) => {
      e.preventDefault();
      showModal("loginTemplate");
    });
  });

  document.querySelectorAll('a[href="#register"], .btn.secondary').forEach((btn) => {
    btn.addEventListener("click", (e) => {
      e.preventDefault();
      showModal("registerTemplate");
    });
  });

  function enableSmoothScroll(triggerId, targetId) {
    document.querySelector(`#${triggerId}`)?.addEventListener("click", (e) => {
      e.preventDefault();
      document.querySelector(`#${targetId}`)?.scrollIntoView({ behavior: "smooth" });
    });
  }

  enableSmoothScroll("Monitoreo", "MonitoreoCard");
  enableSmoothScroll("Asistencia", "AsistenciaCard");
  enableSmoothScroll("Analisis", "AnalisisCard");

  document.addEventListener("click", function (e) {
    if (e.target && e.target.id === "btnLogout") {
      e.preventDefault();
      localStorage.removeItem("loggedIn");
      window.location.href = "/Grupo2-IHC/index.html";
    }
  });

  const menuToggle = document.getElementById("menu-toggle");
  const menu = document.getElementById("menu");
  menuToggle?.addEventListener("click", () => {
    menu.classList.toggle("active");
  });

  const mobileMenuButton = document.getElementById("mobile-menu-button");
  const sidebar = document.querySelector(".sidebar");

  if (mobileMenuButton && sidebar) {
    mobileMenuButton.addEventListener("click", () => {
      sidebar.classList.toggle("active");
    });
  }

});

document.addEventListener("DOMContentLoaded", () => {
  const registros = [
    {
      inputId: "reflection-input",              
      buttonId: "publish-button",
      outputId: "reflection-output"
    },
    {
      inputId: "momentos-criticos-input",       
      buttonId: "publish-momentos",
      outputId: "momentos-criticos-output"
    },
    {
      inputId: "notas-emocion-input",          
      buttonId: "publish-nota",
      outputId: "notas-emocion-output"
    }
  ];

  registros.forEach(({ inputId, buttonId, outputId }) => {
    const input = document.getElementById(inputId);
    const button = document.getElementById(buttonId);
    const output = document.getElementById(outputId);

    if (input && button && output) {
      button.addEventListener("click", () => {
        const text = input.value.trim();
        if (text !== "") {
          const p = document.createElement("p");
          p.textContent = text;
          output.appendChild(p);
          input.value = "";
        }
      });
    }
  });
});

function seleccionarFrase(button, idRespuesta) {
  const texto = button.textContent;
  const respuesta = document.getElementById(idRespuesta);
  if (respuesta) {
    respuesta.textContent = `Respuesta seleccionada: ${texto}`;
  }
}

const invisibleToggle = document.getElementById("invisibleToggle");
const invisibleStatus = document.getElementById("invisibleStatus");

if (invisibleToggle && invisibleStatus) {
  invisibleToggle.addEventListener("change", () => {
    if (invisibleToggle.checked) {
      invisibleStatus.textContent = "Activado";
    } else {
      invisibleStatus.textContent = "Desactivado";
    }
  });
}

