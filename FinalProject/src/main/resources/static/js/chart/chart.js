$(function(){ 
$.ajax({
        url : '/main/chart/userChart',
        type : 'GET',
        dataType : 'json'
    }).done(function(){
        google.charts.load('current', {'packages':['corechart','bar']});
        google.charts.setOnLoadCallback
        (function(){
        	drawUserMonthlyStatusChart();
        });
        google.charts.setOnLoadCallback(drawUserGenderStatusChart);
    }).fail(function(){
        alert('차트안됩니다ㅠ_ㅠ ')
    })
})
function drawUserMonthlyStatusChart(){
    var lists = new Array();
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'loginStatus_Monthly');
    data.addColumn('number', 'JAN');
    data.addColumn('number', 'FEB');
    data.addColumn('number', 'MAR');
    data.addColumn('number', 'APR');
    data.addColumn('number', 'MAY');
    data.addColumn('number', 'JUN');
   
 /*  list.forEach(function(element){
        lists.push([element.logindate + '/' + 1 + '/', 2, 3, 4, 5, 6]);
        });*/
   
   list.forEach(function(element){
       lists.push([element.logindate + '/' + element.JAN + '/', element.FEB, element.MAR, element.APR, element.MAY, element.JUN]);
       });
   
    
    
    data.addRows(lists);
  //data.addRows(parseInt(lists.loginStatus_Monthly); //그래프 값 


    var options = {title:'사용자 통계',chartArea: {width:'100%',height:'400%'},
        legend: 'none', isStacked: true } ;
}
    var chart = new google.visualization.BarChart
    (document.getElementById("myBarChart"));
    chart.draw(data, options);
 
    
function drawUserMonthlyStatusChart() {
		var data = google.visualization
				.arrayToDataTable([
						[ 'Year',
								'Asia',
								'Europe' ],
						[ '2012', 900,
								390 ],
						[ '2013', 1000,
								400 ],
						[ '2014', 1170,
								440 ],
						[ '2015', 1250,
								480 ],
						[ '2016', 1530,
								540 ] ]);
		var options = {
			title : 'Population (in millions)',
			isStacked : true
		};
		var chart = new google.visualization.BarChart($('myAreaChart'));
		chart.draw(data, options);
	}
	google.charts
			.setOnLoadCallback(drawUserMonthlyStatusChart);
	
    console.log("와줘..");
  //google.charts.setOnLoadCallback(drawUserMonthlyStatusChart);
    

    
    


    
    
   