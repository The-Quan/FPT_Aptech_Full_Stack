// middleware.js
const jwt = require('jwt-simple');

// Middleware xác thực JWT
const authenticateJWT = (req, res, next) => {
  const authHeader = req.headers.authorization;
  if (authHeader) {
    const token = authHeader.split(' ')[1];
    try {
      const decoded = jwt.decode(token, process.env.JWT_SECRET);
      req.user = decoded;
      next();
    } catch (err) {
      return res.status(403).json({ message: 'Token không hợp lệ' });
    }
  } else {
    res.status(401).json({ message: 'Thiếu header Authorization' });
  }
};

// Middleware kiểm tra vai trò admin
const checkRole = (...allowedRoles) => {
  return (req, res, next) => {
    // Ensure req.user exists and has a role
    if (req.user && allowedRoles.includes(req.user.role)) {
      return next();
    } else {
      return res.status(403).json({ message: 'Truy cập bị từ chối. Bạn không có quyền truy cập.' });
    }
  };
};

module.exports = { authenticateJWT, checkRole };
