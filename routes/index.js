const express = require('express');
const db = require('../db');

const router = express.Router();

/* GET home page. */
router.get('/', (req, res) => {
  if (req.session.user) {
    res.render('index', { title: 'Express', user: req.session.user });
  } else {
    res.redirect('users/login');
  }
});

router.get('/guest', async (req, res) => {
  const query = 'SELECT * FROM apps;';
  const result = await db.query(query);
  res.render('guest', { title: 'appFinder', rows: result.rows });
});

module.exports = router;
