/**
 * this graph reports best time to work on activities
 */

var sum = function(a, b) {
  return a + b;
};

var activitiesData = {
  series : [ 6, 3, 1 ]
};

new Chartist.Pie('.ct-chart-activities', {
  series : [ 6, 3, 1 ]
}, {
  labelInterpolationFnc : function(value) {
    return Math.round(value / activitiesData.series.reduce(sum) * 100) + '%';
  }
});
