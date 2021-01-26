 function yeniTelebe(){
        var yeniTeleElement=document.createElement('h1');
        yeniTeleElement.innerHTML='Salam Serxan';
        yeniTeleElement.style.backgroundColor=('yellow');
        var mainElement=document.getElementById('main');
        mainElement.appendChild(yeniTeleElement);
    }
         function yeniSekil(){
        var yeniSekillement=document.createElement('img');
        yeniSekillement.style.width=('100px');
        yeniSekillement.style.size=('100px');
        yeniSekillement.src='java.png';
             var mainElement=document.getElementById('main');
        mainElement.appendChild(yeniSekillement);
    }
    