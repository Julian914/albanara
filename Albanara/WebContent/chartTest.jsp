<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/jquery-ui.css">
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/bootstrap-theme.css">
<link rel="stylesheet" href="./css/Chart.css">
<script src="./js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="./js/jquery-ui.js" type="text/javascript"></script>
<script src="./js/bootstrap.js" type="text/javascript"></script>
<script src="./js/Chart.js" type="text/javascript"></script>
<script src="./js/Chart.bundle.js" type="text/javascript"></script>


<title>Insert title here</title>
</head>
<body>
<h1>차트 테스트 페이지</h1>
<table border="1">
	<tr>
		<td><canvas id="myChart1" width="800"></canvas></td>
		<td><canvas id="myChart2" width="800"></canvas></td>
	</tr>
	<tr>
		<td><canvas id="myChart3" width="800"></canvas></td>
		<td><canvas id="myChart4" width="800"></canvas></td>
	</tr>
	<tr>
		<td><canvas id="myChart5" width="800"></canvas></td>
		<td><canvas id="myChart6" width="800"></canvas></td>
	</tr>
	<tr>
		<td><canvas id="myChart7" width="800"></canvas></td>
		<td><canvas id="myChart8" width="800"></canvas></td>
	</tr>
</table>

</body>
<script type="text/javascript">
var ctx1 = document.getElementById('myChart1').getContext('2d');
var ctx1 = $('#myChart1');
var myLineChart1 = new Chart(ctx1, {
    type: 'line',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
            	'rgba(255, 206, 86, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',                
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
            	'rgba(255, 159, 64, 1)',
            	'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)'                
            ],
            borderWidth: 1
        }]
    },
    options: {}
});

var ctx2 = $('#myChart2');
var myChart2 = new Chart(ctx2, {
    type: 'bar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});


var ctx3 = $('#myChart3');
var myDoughnutChart = new Chart(ctx3, {
	type: 'line',
	data: {
		labels: ['Day 1', 'Day 2', 'Day 3', 'Day 4', 'Day 5', 'Day 6'],
		datasets: [{
			label: 'stepped',
			steppedLine: true,
			data: [12, 19, 3, 5, 2, 3],
			borderColor: 'rgba(75, 192, 192, 1)',
			fill: false,
		}]
	},
	options: {
		responsive: true,
		title: {
			display: true,
			text: 'stepped Title',
		}
	}
});

var ctx4 = $('#myChart4');
var myDoughnutChart = new Chart(ctx4, {
    type: 'doughnut',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {}
});

var ctx5 = $('#myChart5');
var myDoughnutChart = new Chart(ctx5, {    
    type: 'polarArea',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 13, 25, 12, 8],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {}
});


var ctx6 = $('#myChart6');
var myDoughnutChart = new Chart(ctx6, {
    type: 'pie',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {}
});


var ctx7 = $('#myChart7');
var myRadarChart = new Chart(ctx7, {
    type: 'radar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 13, 25, 8, 17],
            backgroundColor: [
            	'rgba(255, 206, 86, 0.2)',
            	'rgba(54, 162, 235, 0.2)',
            	'rgba(75, 192, 192, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {}
});


var ctx8 = $('#myChart8');

</script>

</html>