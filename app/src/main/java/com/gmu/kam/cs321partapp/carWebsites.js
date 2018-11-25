var globalArr = "global"

function walmartSearch(make, model, year, item)
{
  var w = window.open("https://www.walmart.com");
  //var document = new Document();
  //alert(document.url);
  //document.url = "https://www.walmart.com";
  //alert(document.url);
  var s = make+" "+model+" "+year+" "+item;
  //alert(document.url);
  w.onload = function(){

  var id = w.document.getElementById('Search');
  id.value = s;
  alert("Hello World");
};

  //alert("*******");
  //w.document.forms[0].submit();
}

function usaSearch(make, model, year, item)
{
  var w = window.open("https://www.usautoparts.net");
  var w = open
  //var document = new Document();
  //alert(document.url);
  //document.url = "https://www.walmart.com";
  //alert(document.url);
  //alert(w.onload);
  var s = make+" "+model+" "+year+" "+item;
  //alert(document.url);
  // w.document.addEventListener("DOMContentLoaded",
  w.onload = function(){

  var id = w.document.getElementById('Search');
  id.value = s;
  alert("Hello World");
};
  //alert("*******");
  //w.document.forms[0].submit();
}

function carPartsSearch(make, model, year, item)
{
  window.open("https://www.carparts.com");
  var s = make+" "+model+" "+year+" "+item;
  // document.getElementById('global-search-input').value=s;
  // document.forms[0].submit();

  //alert("*******");
  //w.document.forms[0].submit();
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
  //alert("*******");
  //w.document.forms[0].submit();
}

//walmartSearch("toyota", "corolla", "2016", "tires");
usaSearch("toyota", "corolla", "2016", "tires");
// carPartsSearch("toyota", "corolla", "2016", "tires");
//carIdSearch("toyota", "corolla", "2016", "tires");
