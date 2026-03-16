# 🚀 CI/CD Spring Boot với GitHub Actions & Docker Hub

## 📌 Giới thiệu

Dự án này minh họa cách sử dụng **GitHub Actions** để tự động hóa quy trình **CI/CD** cho ứng dụng **Java Spring Boot**.

Khi code được **push lên nhánh `main`**, hệ thống sẽ tự động:

1. Đăng nhập vào **Docker Hub**
2. **Build Docker Image** từ `Dockerfile`
3. **Push Docker Image** lên Docker Hub

Quy trình này giúp tự động hóa việc build và deploy ứng dụng.

---

# 🛠 Công nghệ sử dụng

* Java Spring Boot
* Docker
* GitHub Actions
* Docker Hub
* Maven

---

# 📂 Cấu trúc dự án

```
project-springboot/
│
├── src/
├── pom.xml
├── Dockerfile
│
└── .github
    └── workflows
        └── deploy.yml
```

---

# ⚙️ Bước 1: Tạo Repository GitHub

Tạo repository trên GitHub và push source code dự án Spring Boot lên.

```
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin <repo-url>
git push -u origin main
```

---

# 🔐 Bước 2: Cấu hình GitHub Secrets

Vào:

```
Repository → Settings → Secrets and variables → Actions
```

Thêm 2 secrets:

| Name               | Value                   |
| ------------------ | ----------------------- |
| DOCKERHUB_USERNAME | username docker hub     |
| DOCKERHUB_TOKEN    | access token docker hub |

Docker Hub Token tạo tại:

```
Docker Hub → Account Settings → Security → New Access Token
```

---

# ⚡ Bước 3: Tạo GitHub Actions Workflow

Tạo file:

```
.github/workflows/deploy.yml
```

Nội dung:

```yaml
name: Build and Push Docker Image

on:
  push:
    branches:
      - main

jobs:
  docker:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout source code
        uses: actions/checkout@v4

      - name: Login Docker Hub
        uses: docker/login-action@v3
        with:
          username: ${{ secrets.DOCKERHUB_USERNAME }}
          password: ${{ secrets.DOCKERHUB_TOKEN }}

      - name: Build and Push Docker Image
        uses: docker/build-push-action@v5
        with:
          context: .
          push: true
          tags: ${{ secrets.DOCKERHUB_USERNAME }}/springboot-app:latest
```

---

# 🔄 Quy trình hoạt động

```
Push code lên GitHub
        ↓
GitHub Actions trigger workflow
        ↓
Login Docker Hub
        ↓
Build Docker Image
        ↓
Push Image lên Docker Hub
```

---

# 🐳 Docker Image

Sau khi workflow chạy thành công, image sẽ được push lên:

```
https://hub.docker.com/
```

Ví dụ:

```
docker pull username/springboot-app:latest
```

---

# ▶️ Chạy container

Sau khi pull image:

```
docker run -p 8080:8080 username/springboot-app
```

Truy cập ứng dụng:

```
http://localhost:8080
```

---

# 📊 GitHub Actions

Có thể xem workflow chạy tại:

```
Repository → Actions
```

Mỗi lần push code lên `main`, workflow sẽ chạy tự động.

---

# 🎯 Kết luận

Bài tập này giúp:

* Hiểu cách hoạt động của **CI/CD**
* Tự động hóa build Docker image
* Sử dụng **GitHub Actions** để deploy

---

# 👨‍💻 Author

Sinh viên thực hiện bài tập GitHub Actions
Trường **HUTECH - Đại học Công Nghệ TP.HCM**

⭐ Nếu thấy repo hữu ích hãy cho repo một **Star** nhé!
