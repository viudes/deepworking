var reportBestTime = (function() {

  var ctx = document.getElementById("chart-best-time"),
      chart = {};

  var getLabels = function() {
    var labels = [];
    for (i = 0; i < 23; i++) {
      labels.push(i);
    }
    return labels;
  };

  var timeOfFocus = function() {
  var focus = [];
    for (i = 0; i < 23; i++) {
      focus.push(Math.random() * 9);
    }
    return focus;
  };

  var getScores = function() {
    var scores = [];
    for (i = 0; i < 23; i++) {
      scores.push(Math.random() * 3);
    }
    return scores;
  };

  chart.get = function() {
    return new Chart(ctx, {
      type: 'line',
      data: {
        labels: getLabels(),
        datasets: [{
          label: 'Time spent working',
          data: timeOfFocus(),
          fill: false,
          lineTension: 0,
          borderColor: 'rgba(255, 99, 132, 0.8)',
          backgroundColor: 'rgba(255, 99, 132, 0.8)'
        }, {
          label: 'Score',
          data: getScores(),
          fill: false,
          lineTension: 0,
          borderColor: 'rgba(75, 192, 192, 0.8)',
          backgroundColor: 'rgba(75, 192, 192, 0.8)'
        }]
      },
      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero:true
            }
          }]
        }
      }
    });
  };

  return chart;

})();

reportBestTime.get();

