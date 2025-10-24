console.log("✨ Hello from external JS file");

document.addEventListener("DOMContentLoaded", () => {
  //     const btn = document.getElementById("btnFirstinJava");
  //   if (!btn) return; // guard
  //   btn.addEventListener("click", () => {
  //     //    console.log('clicked'); alert('Button clicked!');
  //     loadData();
  //   });

  //   btnSecond.addEventListener("click", () => {
  //     getCell(Math.floor(Math.random() * (8 + 1)));
  //   });

  btnReset.addEventListener("click", () => {
    reset();
  });

  const buttons = document.querySelectorAll(".btnTT");
  buttons.forEach((btn) => {
    btn.addEventListener("click", () => {
      getCell(btn.id);
    });
  });

  //   function loadData() {
  //     fetch("/demo2/reset") // URL to your Spring controller
  //       .then((response) => response.text()) // or .json() if it's JSON
  //       .then((data) => {
  //         var arr = data.replace(/[\[\]\s]/g, "").split(",");
  //         for (var i = 0; i < arr.length; i++) {
  //           console.log("Cell " + (i + 1) + ": " + arr[i]);
  //         }

  //         // alert("Data from server: " + data);
  //         // document.getElementById("result").innerText = data;
  //       })
  //       .catch((error) => console.error("Error:", error));
  //   }

  function getCell(cellNo) {
    fetch(`/demo2/get-cell?cellNo=${cellNo}`) // URL to your Spring controller
      .then((response) => response.text()) // or .json() if it's JSON
      .then((data) => {
        // alert("Data for cell " + cellNo + ": " + data);
        // document.getElementById("result").innerText = data;
        // console.log("Data for cell " + cellNo + ": " + data);
        var arr = data.replace(/[\[\]\s]/g, "").split(",");
        fillTable(arr);
        checkWin();
      })
      .catch((error) => console.error("Error:", error));
  }

  function reset() {
    fetch(`/demo2/reset`)
      .then((response) => response.text()) // or .json() if it's JSON
      .then((data) => {
        // console.log("Data for cell: " + data);
        var arr = data.replace(/[\[\]\s]/g, "").split(",");
        fillTable(arr);
        document.getElementById("result").innerText = " ";

        document.querySelectorAll(".btnTT");
        buttons.forEach((btn) => {
          btn.disabled = false;
        });
      })
      .catch((error) => console.error("Error:", error));
  }

  function fillTable(arr) {
    var i = 0;
    document.querySelectorAll(".btnTT");
    buttons.forEach((btn) => {
      if (arr[i] == "1") btn.innerHTML = "x";
      else if (arr[i] == "2") btn.innerHTML = "o";
      else if (arr[i] == "0") btn.innerHTML = "";
      i++;
    });
  }

  function checkWin() {
    fetch(`/demo2/check-win`)
      .then((response) => response.text()) // or .json() if it's JSON
      .then((data) => {
        if (data !== "") {
          document.getElementById("result").innerText = data;

          document.querySelectorAll(".btnTT");
          buttons.forEach((btn) => {
            btn.disabled = true;
          });
        } else {
          document.getElementById("result").innerText = " ";
        }
      })
      .catch((error) => console.error("Error:", error));
  }
});
