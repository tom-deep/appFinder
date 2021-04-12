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

router.get('/add-review/:id', async (req, res) => {
  const query = 'SELECT * FROM apps WHERE id = $1;';
  const params = [req.params.id];
  const result = await db.query(query, params);

  res.render('add-review', { rows: result.rows });
});

router.get('/app-view/:id', async (req, res) => {
  const query = 'SELECT * FROM apps WHERE id = $1;';
  const params = [req.params.id];
  const result = await db.query(query, params);

  res.render('app-view', { rows: result.rows });
});
module.exports = router;
