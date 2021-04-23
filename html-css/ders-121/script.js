var kategoryaB = true;
var kategoriyaList = [];
var kategoriyaListString = localStorage.getItem("kategoriyaList1");
var stringFilter = "Hamisini goster";
var filterTable;
var boofilterTable = true;
if (kategoriyaListString == null) {

} else {
  kategoriyaList = JSON.parse(kategoriyaListString);
}
var taskList = [];
var taskListString = localStorage.getItem("taskList1");
if (taskListString == null) {

} else {
  taskList = JSON.parse(taskListString);
}

function deleteCategory(id) {
  var dltcate;

  for (var i = 0; i < kategoriyaList.length; i++) {
    if (kategoriyaList[i].id == id) {
      dltcate = kategoriyaList[i].kategoriyaName;
      kategoriyaList.splice(i, 1);



    }

  }
  for (var i = 0; i < taskList.length; i++) {


    if (taskList[i].kategoriya == dltcate) {
      taskList.splice(i, 3);

    }



  }




  localStorage.setItem("kategoriyaList1", JSON.stringify(kategoriyaList));
  localStorage.setItem("taskList1", JSON.stringify(taskList));
  kategoriyaTableShow();
  tasktableShow(filterTable);

}

function categoriFilter() {
  filterTable = document.getElementById('categoriFilter').value;
  tasktableShow(filterTable);
  console.log(filterTable);


};

function deleteTask(id) {
  for (var i = 0; i < taskList.length; i++) {
    if (taskList[i].id == id) {
      taskList.splice(i, 1);

    }
  }
  localStorage.setItem("taskList1", JSON.stringify(taskList));
  tasktableShow(filterTable);
}


kategoriyaTableShow();

function kategoriyaTableShow() {
  var stringctatab = "";
  document.getElementById("kategoriyaTable").innerHTML = stringctatab;
  for (var i = 0; i < kategoriyaList.length; i++) {
    var x = kategoriyaList[i];
    var xyz = i + 1;

    stringctatab += "<tr><td>" + xyz + "</td><td>" + x.kategoriyaName + "</td>" +
      "<td><button  class='btn btn-border btn-danger '  onClick='deleteCategory(" + x.id + ")'>Sil</button></td></tr>";
  }
  document.getElementById("kategoriyaTable").innerHTML = stringctatab;
}
tasktableShow(filterTable);

function tasktableShow(filter) {
  boofilterTable = true;
  var b1, b2 = "";
  var string = "";
  document.getElementById("taskTable").innerHTML = string;
  for (var i = 0; i < taskList.length; i++) {
    boofilterTable = true;
    b1, b2 = "";
    var x = taskList[i];
    var xyz = i + 1;
    if (filter == null) {
      boofilterTable = false;
      if (x.status == false) {
        b1 = "";
        b2 = "checked='true'";

      }
      if (x.status == true) {
        b2 = "";
        b1 = "checked='true'";

      }

      string += "<tr><td>" + xyz + "</td><td>" + x.task + "</td>" +
        "<td>" + x.timestart + "</td><td>" + x.timefinish + "</td><td>" + x.kategoriya + "</td>" +
        "<td><ul id='" + xyz + "'><input type='radio'name='" + xyz + "' id='" + xyz + "b' " + b1 + " onclick='statusDeyismek(" + xyz + ")' /> Pis " +
        "<br><input type='radio' name='" + xyz + "' id='" + xyz + "' " + b2 + "    onclick='statusDeyismek(" + xyz + ")' /> Yaxsi</ul> </td>" +
        "<td><button  class='btn btn-border btn-danger '  onClick='deleteTask(" + x.id + ")'>Sil</button></td></tr>";
    }
    if (filter == x.kategoriya) {
      boofilterTable = false;
      if (x.status == false) {
        b1 = "";
        b2 = "checked='true'";

      }
      if (x.status == true) {
        b2 = "";
        b1 = "checked='true'";

      }

      string += "<tr><td>" + xyz + "</td><td>" + x.task + "</td>" +
        "<td>" + x.timestart + "</td><td>" + x.timefinish + "</td><td>" + x.kategoriya + "</td>" +
        "<td><ul id='" + xyz + "'><input type='radio'name='" + xyz + "' id='" + xyz + "b' " + b1 + " onclick='statusDeyismek(" + xyz + ")' /> Pis " +
        "<br><input type='radio' name='" + xyz + "' id='" + xyz + "' " + b2 + "    onclick='statusDeyismek(" + xyz + ")' /> Yaxsi</ul> </td>" +
        "<td><button  class='btn btn-border btn-danger '  onClick='deleteTask(" + x.id + ")'>Sil</button></td></tr>";
    }
    if (filter == stringFilter) {
      if (x.status == false) {
        b1 = "";
        b2 = "checked='true'";

      }
      if (x.status == true) {
        b2 = "";
        b1 = "checked='true'";

      }

      string += "<tr><td>" + xyz + "</td><td>" + x.task + "</td>" +
        "<td>" + x.timestart + "</td><td>" + x.timefinish + "</td><td>" + x.kategoriya + "</td>" +
        "<td><ul id='" + xyz + "'><input type='radio'name='" + xyz + "' id='" + xyz + "b' " + b1 + " onclick='statusDeyismek(" + xyz + ")' /> Pis " +
        "<br><input type='radio' name='" + xyz + "' id='" + xyz + "' " + b2 + "    onclick='statusDeyismek(" + xyz + ")' /> Yaxsi</ul> </td>" +
        "<td><button  class='btn btn-border btn-danger '  onClick='deleteTask(" + x.id + ")'>Sil</button></td></tr>";
    }


  }
  document.getElementById("taskTable").innerHTML = string;
}

function statusDeyismek(id) {
  var idS = id - 1;
  if (document.getElementById(id + "b").checked == true) {
    taskList[idS].status = true;
    localStorage.setItem("taskList1", JSON.stringify(taskList));
    tasktableShow(filterTable);
  } else {
    taskList[idS].status = false;
    localStorage.setItem("taskList1", JSON.stringify(taskList));
    tasktableShow(filterTable);
  }

};

$(document).ready(() => {
  kategoriyacomboboxShow();

  function kategoriyacomboboxShow() {
    var string = "";
    $("#categori").html("");
    $("#categoriFilter").html("<option>" + stringFilter + "</option>");
    for (var i = 0; i < kategoriyaList.length; i++) {
      var x = kategoriyaList[i];


      $("#categori").append("<option>" + x.kategoriyaName + "</option>");
      $("#categoriFilter").append("<option>" + x.kategoriyaName + "</option>");
    }


  }


  $("#new-task-open").click(function () {

    $("#lightbox").css("display", "block");
  });

  $("#closeTask").click(function () {

    $("#lightbox").css("display", "none");
  });
  $("#categoritenzim").click(function () {

    $("#lightboxkategoriya").css("display", "block");
    $("#lightbox").css("display", "none");
    kategoriyaTableShow();
  });
  $("#closeCategori").click(function () {

    $("#lightboxkategoriya").css("display", "none");
    $("#lightbox").css("display", "block");
    kategoriyacomboboxShow();
  });
  $("#saveCategori").click(function () {
    var x = $('#kategoriyaInput').val();

    var y = {
      id: kategoriyaList.length + 1,
      kategoriyaName: x
    }

    kategoriyaList.push(y);
    localStorage.setItem("kategoriyaList1", JSON.stringify(kategoriyaList));
    kategoriyaTableShow();



  });


  $("#saveTask").click(function () {

    var tas = $('#taskInput').val();
    var soy = $('#soyInput').val();
    var day = $('#lastDayInput').val();
    var kategoriya = $('#categori').val();

    var obyekt = {
      id: taskList.length + 1,
      task: tas,
      timefinish: day,
      timestart: soy,
      kategoriya: kategoriya,
      status: false
    }

    taskList.push(obyekt);
    localStorage.setItem("taskList1", JSON.stringify(taskList));
    tasktableShow(filterTable);
  });






  //$('textarea').on('input', function() {
  //  text = $('textarea').val();
  //  $('div').html(text);
  //});
  $('#taskInput').on('input', function () {
    var err = "";
    var errB = true;
    var x = $('#taskInput').val();
    console.log(x.length);

    if (x.length < 2) {
      ;
      err = "Ad minimum 2 simvol olmalıdır.";
      errB = false;
      kategoryaB = false;
    }
    if (x.length == 0) {
      ;
      err = "Adi boş qoymaq olmaz";
      errB = false;
      kategoryaB = false;
    };
    if (x.length > 50) {
      ;
      err = "Ad maksimum 50 simvol olmalıdır.";
      errB = false;
      kategoryaB = false;
    }
    if (errB) {
      $("#taskInput").removeClass("form-content-error");
      $("#taskInput").addClass("form-content");
      $("#task-error").text("");
    } else {

      $("#taskInput").removeClass("form-content");
      $("#taskInput").addClass("form-content-error");
      $("#task-error").text(err);
    }
  });
  $('#kategoriyaInput').on('input', function () {
    var kategoryaB = true;
    var err = "";
    var errB = true;
    var x = $('#kategoriyaInput').val();
    console.log(x.length);

    if (x.length < 2) {
      ;
      err = "Kategoriyani minimum 2 simvol olmalıdır.";
      errB = false;
      kategoryaB = false;
    }
    if (x.length == 0) {
      ;
      err = "Kategoriyani boş qoymaq olmaz";
      errB = false;
      kategoryaB = false;
    };
    if (x.length > 20) {
      ;
      err = "Kategoriya maksimum 20 simvol olmalıdır.";
      errB = false;
      kategoryaB = false;
    }
    if (errB) {
      $("#kategoriyaInput").removeClass("form-content-error");
      $("#kategoriyaInput").addClass("form-content");
      $("#kategoriyaP").text("");
    } else {

      $("#kategoriyaInput").removeClass("form-content");
      $("#kategoriyaInput").addClass("form-content-error");
      $("#kategoriyaP").text(err);
    }
  });


  $('#lastDayInput').on('input', function () {
    var err = "";
    var errB = true;
    var x = $('#lastDayInput').val();
    console.log(x.length);

    if (x == "") {
      err = "Tevullud bos qoymaq olmaz";
      errB = false;
    }

    if (errB) {
      $("#lastDayInput").removeClass("form-content-error");
      $("#lastDayInput").addClass("form-content");
      $("#lastdayP").text("");
    } else {

      $("#lastDayInput").removeClass("form-content");
      $("#lastDayInput").addClass("form-content-error");
      $("#lastdayP").text(err);
    }
  });
});


$('#soyInput').on('input', function () {
  var err = "";
  var errB = true;
  var x = $('#soyInput').val();
  console.log(x.length);

  if (x.length < 2) {
    ;
    err = "Soyad minimum 2 simvol olmalıdır.";
    errB = false;
    kategoryaB = false;
  }
  if (x.length == 0) {
    ;
    err = "Soyadi boş qoymaq olmaz";
    errB = false;
    kategoryaB = false;
  };
  if (x.length > 50) {
    ;
    err = "Soyad maksimum 50 simvol olmalıdır.";
    errB = false;
    kategoryaB = false;
  }
  if (errB) {
    $("#soyInput").removeClass("form-content-error");
    $("#soyInput").addClass("form-content");
    $("#soy-error").text("");
  } else {

    $("#soyInput").removeClass("form-content");
    $("#soyInput").addClass("form-content-error");
    $("#soy-error").text(err);
  }
});