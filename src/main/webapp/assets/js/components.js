var deepworking = {};

(function() {
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
