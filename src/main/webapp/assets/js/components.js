var deepworking = {};

(function() {
  deepworking.smartList = {
    options: {
      container: null,
      addButton: null,
      row: null,
      allowDelete: false
    },

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
        var $hiddenName = $('<input>'),
            $hiddenDescription = $('<input>');

        $hiddenName.prop('type', 'hidden')
          .prop('name', 'activityName')
          .val($inputName.val());

        $hiddenDescription.prop('type', 'hidden')
          .prop('name', 'activityDescription')
          .val($inputDesc.val());

        $hiddenName.appendTo(self.options.container);
        $hiddenDescription.appendTo(self.options.container);

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

  };
})();
