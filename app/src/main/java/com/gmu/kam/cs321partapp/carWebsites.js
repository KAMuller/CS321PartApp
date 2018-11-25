var globalArr = "global"

function walmartSearch(make, model, year, item)
{
  var w = window.open("https://www.walmart.com");

  var s = make+" "+model+" "+year+" "+item;

  w.onload = function(){

    var id = w.document.getElementById('Search');
    id.value = s;
    alert("Hello World");
  };

}

function usaSearch(make, model, year, item)
{
  var w = window.open("https://www.usautoparts.net");
  var w = open

  var s = make+" "+model+" "+year+" "+item;

  w.onload = function(){

    var id = w.document.getElementById('Search');
    id.value = s;
    alert("Hello World");
  };

}

function carPartsSearch(make, model, year, item)
{
  window.open("https://www.carparts.com");
  var s = make+" "+model+" "+year+" "+item;
  w.onload = function(){

    var id = w.document.getElementById('Search');
    id.value = s;
    alert("Hello World");
  };
}

function carIdSearch(make, model, year, item)
{
  var s = make+" "+model+" "+year+" "+item;
  w.onload = function(){

    var id = w.document.getElementById('Search');
    id.value = s;
    alert("Hello World");
  };
}

//walmartSearch("toyota", "corolla", "2016", "tires");
usaSearch("toyota", "corolla", "2016", "tires");
// carPartsSearch("toyota", "corolla", "2016", "tires");
//carIdSearch("toyota", "corolla", "2016", "tires");
