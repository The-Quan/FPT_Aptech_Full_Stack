CREATE VIEW vw_TongLuongTheoPhongBan AS
SELECT
    pb.MaPhongBan,
    pb.TenPhongBan,
    SUM(luong.LuongNet) AS TongLuong
FROM
    PhongBans pb
JOIN
    NhanViens nv ON pb.MaPhongBan = nv.MaPhongBan
JOIN
    Luongs luong ON nv.MaNhanVien = luong.MaNhanVien
GROUP BY
    pb.MaPhongBan, pb.TenPhongBan
WITH CHECK OPTION;
