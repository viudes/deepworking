var reportActivities = (function() {

  var ctx = document.getElementById("chart-activities"),
    chart = {};

  var getLabels = function() {
    return ["Write", "Structure", "Study", "Read"];
  };

  chart.get = function() {
    return new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: getLabels(),
            datasets: [{
                label: '# of Votes',
                data: [70, 10, 5, 15,],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.8)',
                    'rgba(54, 162, 235, 0.8)',
                    'rgba(255, 206, 86, 0.8)',
                    'rgba(75, 192, 192, 0.8)'
                ],
                borderWidth: 1
            }]
        }
    });

  }

  return chart;

})();

reportActivities.get();

