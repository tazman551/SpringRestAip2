##  Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
# Start XAMPP Apache and MySQL
Start-Process -FilePath "C:\xampp\xampp_start.exe"

# Wait a few seconds to ensure XAMPP services are up
Start-Sleep -Seconds 5

# Start Spring Boot REST API
Start-Process -WorkingDirectory "C:\Users\tazma\Documents\Angular_Projects\restapi"  -FilePath "cmd.exe" -ArgumentList "/c mvn spring-boot:run"

# Start Angular dev server
Start-Process -WorkingDirectory "C:\Users\tazma\Documents\Angular_Projects\Angular 17\Elderwood" -FilePath "cmd.exe" -ArgumentList "/c ng serve --open"