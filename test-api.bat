@echo off
echo Testing TabungIn REST API
echo ========================

echo.
echo 1. Testing Registration Endpoint
echo ---------------------------------
curl -X POST http://localhost:8080/api/auth/register ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"testuser123\",\"email\":\"test@example.com\",\"no_hp\":\"081234567890\",\"password\":\"Test123@\",\"nama_lengkap\":\"Test User\",\"alamat\":\"Jalan Test No 123 Jakarta Selatan Indonesia\",\"tanggal_lahir\":\"1990-01-01\"}"

echo.
echo.
echo 2. Testing Login Endpoint
echo -------------------------
curl -X POST http://localhost:8080/api/auth/login ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"testuser123\",\"password\":\"Test123@\"}"

echo.
echo.
echo 3. Testing Get All Users
echo ------------------------
curl -X GET http://localhost:8080/users/all

echo.
echo.
echo 4. Testing Create User (Alternative)
echo ------------------------------------
curl -X POST http://localhost:8080/users ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"user456\",\"email\":\"user456@test.com\",\"noHp\":\"081987654321\",\"password\":\"User456@\",\"namaLengkap\":\"User Test 456\",\"alamat\":\"Jalan User 456 Jakarta Utara Indonesia\",\"tanggalLahir\":\"1995-05-15\"}"

echo.
echo.
echo Test completed!
pause
