const express = require('express');

const router = express.Router();

/* GET home page. */
router.get('/', (req, res) => {
  if (req.session.user) {
    res.render('index', { title: 'Express', user: req.session.user });
  } else {
    res.redirect('users/login');
  }
});

module.exports = router;
