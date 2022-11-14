$('.DNchange').click(function() {
    $('body').toggleClass('day');
    $('body').toggleClass('night');
});
$('.showsearch').click(function() {
    $('.checkwindow').toggleClass('hide');
});

$('.search').click(function (){
    checkPremise();
    requestData();
});

function checkPremise(){
    $.ajax({
        url: "premise",
        type: "get",
        datatype: "json",
        success:function (){
            let str =  $("#text-name").text();
            console.info(str);
        },
        error:function (msg){
            alert("ajax连接异常"+msg);
        }
    });
}

function requestData(){
    $.ajax({
        url:"list",
        type: "post",
        datatype: "json",
        success: function (data){
            let obj = JSON.parse(data)
            for(let i=0;i<obj.length;i++) {
                let str = "<tr><td>" + obj[i].id +
                "</td><td>" + obj[i].name +
                "</td><td>" + obj[i].occupation +
                "</td><td>" + obj[i].power +
                "</td></tr>"
                $("#tab").append(str);
            }
        },
        error: function (msg){
            alert("ajax连接异常"+msg);
        }
    });
}