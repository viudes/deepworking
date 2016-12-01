/**
 * this graph reports best time to work on activities
 */
var data = {
  labels : [ 'Mon', 'Tue', 'Wed', 'Thu', 'Fri' ],
  series : [ {
    name : 'serie 1',
    data : [ 5, 2, 4, 2, 0 ]
  }, {
    name : 'serie 2',
    data : [ 2, 4, 3, 1, 5 ]
  } ]
};

var options = {
  lineSmooth : false,

  chartPadding : {
    top : 20,
    right : 0,
    bottom : 30,
    left : 0
  },

  plugins : [ Chartist.plugins.ctAxisTitle({
    axisX : {
      axisTitle : 'Time (mins)',
      axisClass : 'ct-axis-title',
      offset : {
        x : 0,
        y : 50
      },
      textAnchor : 'middle'
    },
    axisY : {
      axisTitle : 'Goals',
      axisClass : 'ct-axis-title',
      offset : {
        x : 0,
        y : 0
      },
      textAnchor : 'middle',
      flipTitle : false
    }
  }) ]
};

new Chartist.Line('.ct-chart-best-time', data, options);
