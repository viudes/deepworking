var deepworking = {};

(function() {

  deepworking.timePicker = {
    init: function($input) {
       $input.timepicker({
         showMeridian: false,
         showSeconds: true
       });
    }
  };

  deepworking.datePicker = {

    init: function($date) {

      $date.datepicker({
        format: "dd/mm/yyyy",
        titleFormat: "MM yyyy"
      }).on('changeDate', function(evt) {
        $('.datepicker-dropdown').hide();
      });


    }

  };

  /** typeahead wrapper component **/
  deepworking.typeahead = {
    options: {
      dataSourceUri: null
    },

    init: function($typeAheadElement, options) {
      var self = this;

      $.extend(this.options, options);

      $.ajax(self.options.dataSourceUri)
        .done(function(data) {
          $typeAheadElement.typeahead({
            hint: true,
            highlight: true,
            minLength: 1
          }, {
            source: self._substringMatcher(data)
          });
        });
    },

    _substringMatcher: function(items) {
      return function findMatches(q, cb) {
        var matches, substringRegex;

        // an array that will be populated with substring matches
        matches = [];

        // regex used to determine if a string contains the substring `q`
        substrRegex = new RegExp(q, 'i');

        // iterate through the pool of strings and for any string that
        // contains the substring `q`, add it to the `matches` array
        $.each(items, function(i, item) {
          var str = item.name;
          if (substrRegex.test(str)) {
            matches.push(str);
          }
        });

        cb(matches);
      };
    }
  };

  /** smartlist component */
  deepworking.smartList = {
    options: {
      container: null,
      addButton: null,
      row: null,
      allowDelete: false
    },

    model: [],

    create: function(options) {
      $.extend(this.options, options);
      var self = this;

      // add row items to container
      $(options.addButton).bind('click', function(evt) {
        $row = $(options.row).first().clone();

        var $inputName = $('.inputRowName'),
            $inputDesc = $('.inputRowDescription');

        if ($inputName.val().length == 0 || $inputDesc.val().length == 0) {
            return;
        }

        self.addRow(self, $row, $inputName, $inputDesc);

        // if allowDelete show delete button
        if (self.options.allowDelete) {
          $del = self.createDeleteButton();
          $deleteBox = $row.find('.deleteBox').first();
          $del.appendTo($deleteBox);
          $del.bind('click', function(evt) {
            $(this).parent().parent().remove();
          });
        }

        // add hidden fields for each input entry
        self._addEntry($inputName.val(), $inputDesc.val(), function(entry) {
          var $hiddenName = $('<input>'),
              $hiddenDescription = $('<input>');

          $hiddenName.prop('type', 'hidden')
            .prop('name', 'activityTypes[' + entry.getIndex() + '].name')
            .val(entry.getName());

          $hiddenDescription.prop('type', 'hidden')
            .prop('name', 'activityTypes[' + entry.getIndex() + '].description')
            .val(entry.getDescription());

          $hiddenName.appendTo(self.options.container);
          $hiddenDescription.appendTo(self.options.container);
        });

        // clear
        $inputName.val('');
        $inputDesc.val('');
        $inputName.focus();

      });
    },

    addRow: function(self, $row, $inputName, $inputDesc) {
        $row.find('.name').text($inputName.val());
        $row.find('.description').text($inputDesc.val());
        $row.appendTo(self.options.container);
    },

    createDeleteButton: function(self) {
      var $button = $('<a>');
      $button.addClass('btn').addClass('btn-danger');
      $button.text('Delete');
      return $button;
    },

    _addEntry: function(name, description, updateView) {
        var self = this,
            entry = {
              _index: -1,
              _name: name,
              _description: description,
              getIndex: function() { return this._index; },
              getName: function() { return this._name; },
              getDescription: function() { return this._description; },
              updateIndex: function() {
                  var i=0, max = -1;
                  for (i=0; i<self.model.length; i++) {
                    if (self.model[i].getIndex() > max) {
                      max = self.model[i].getIndex();
                    }
                  }
                  this._index = max + 1;
              }
            };

        entry.updateIndex()
        self.model.push(entry);

        updateView(entry);
    },

  };
})();
