# 🧩 Modular Monolith (Hexagonal Architecture)

## 🌐 Modular Monolith란?

**Modular Monolith**는 하나의 애플리케이션 안에서 여러 **독립된 도메인 모듈(Module)** 이 서로 **명확한 경계(Boundary)** 를 가지고 협력하는 구조입니다.

> ### ✅ Modular Monolith의 핵심 장점

### 1. 느슨한 결합 (Loose Coupling)
  - 모듈끼리 **직접적인 코드로 얽혀있지 않고**, 오직 **명시적인 계약(Port, Interface, Event 등)** 을 통해서만 소통합니다. 덕분에 한 모듈의 변경이 다른 모듈에 **거의 영향을 주지 않습니다.**

### 2. 높은 응집도 (High Cohesion)
  - 각 모듈은 **자신의 도메인 책임과 비즈니스 로직에만 집중**합니다. 관련 있는 기능들이 하나의 모듈 안에 **똘똘 뭉쳐있게 됩니다.**

### 3. 도메인 독립성 (Domain Isolation)
  - 모듈 간의 **변경 영향이 최소화**되어, 모듈별로 **독립적인 개발, 배포, 테스트**가 가능해집니다.

### 4. 확장성 (Scalability)
  - 이렇게 **잘 분리된 모듈**은 나중에 트래픽이 몰리거나 중요도가 높아졌을 때, 해당 모듈만 따로 떼어내어 **마이크로서비스(MSA)로 점진적으로 전환**하기 매우 **용이합니다.**

### 5. 유지보수성 (Maintainability)
  - 모듈 간의 **경계가 명확하기 때문에**, 코드를 변경할 때 그 **영향 범위를 예측하기가 훨씬 쉬워집니다.**
---


## 📘 현재 구조 개요

현재 시스템은 **Modular Monolith + Hexagonal Architecture** 기반으로 설계되어 있습니다.  
각 모듈은 도메인 단위로 구성되어 있으며, **Order → Product**, **Order → Member** 로 **단방향 의존성**을 가지고 있습니다.

<img width="1050" height="243" alt="Image" src="https://github.com/user-attachments/assets/38320f61-a072-46e9-aee4-48d153fd2ba1" />

---

## 🧱 아키텍처 설명

### Order 모듈
- `OrderServiceImpl`이 중심이 되어 주문 관련 핵심 비즈니스 로직을 수행합니다.
- 외부 도메인과의 연동은 `Port` 인터페이스를 통해 수행합니다.
- `ProductPort`, `MemberPort`를 통해 `Product`, `Member` 모듈에 접근합니다.

### Product 모듈
- 내부적으로 `ProductInternalUseCase`를 통해 자신의 로직을 수행하며,
- 외부에서 접근할 수 있는 인터페이스를 최소화했습니다.

### Member 모듈
- `MemberInternalUseCase`를 중심으로 회원 관련 로직을 수행합니다.
- Order 모듈에서 `MemberPort`를 통해 접근합니다.

---

## 🚀 각 모듈은 다음과 같이 구성됩니다.
- **Domain** : 비즈니스 로직, 엔티티, 도메인 서비스
- **Application** : UseCase 인터페이스 정의
- **Adapter (in/out)** : 외부 연동 및 인프라 의존 구현체
- **Port** : 모듈 간 통신 인터페이스

### 💡 모듈 내 구성 요약

| 구분 | 역할 | 방향 | 예시 |
|------|------|------|------|
| **port.in** | 외부에서 내부 모듈로 들어오는 요청 인터페이스 | 외부 → 내부 | `OrderUseCase`, `MemberInternalUseCase` |
| **port.out** | 내부 모듈이 외부 시스템 또는 다른 도메인으로 요청 | 내부 → 외부 | `MemberPort`, `ProductPort` |
| **adapter.in** | `port.in` 구현체 (Controller, Consumer 등) | 외부 → 내부 | `OrderController`, `MemberApiController` |
| **adapter.out** | `port.out` 구현체 (API Client, Repository 등) | 내부 → 외부 | `MemberAdapter`, `ProductAdapter` |

---

이 구조는 **헥사고날 아키텍처의 “입출력 경계(Inbound / Outbound Port)” 개념을 명확히 표현**합니다.  
- `in`은 **외부 요청이 들어오는 관문**,  
- `out`은 **내부에서 외부로 나가는 통신 통로**,  
- `adapter`는 **이 포트를 실제로 구현하는 구체 계층**입니다.  

---

<img width="1512" height="1026" alt="Image" src="https://github.com/user-attachments/assets/06a523f3-f037-4622-bbb6-90cb70071afe" />

## ⚙️ 그러나, 현재 구조는 “느슨한 결합”이 아니다

모듈러 모노리스의 핵심은 **느슨한 결합(Loose Coupling)** 입니다.  
즉, **한 모듈이 다른 모듈의 구체적인 존재를 몰라도 협력할 수 있는 구조**여야 합니다.

하지만 현재 구조는 아래와 같습니다 👇

Order → Member  
Order → Product

- `OrderServiceImpl`이 `MemberPort`, `ProductPort`를 직접 호출하며,  
- 각 `Adapter`는 `MemberInternalUseCase`, `ProductInternalUseCase`를 직접 실행합니다.  

이 말은, **Port 인터페이스를 통해 간접 호출하더라도, 실제로는 “직접 의존 관계”가 존재한다는 뜻**입니다.  
즉, **현재 구조는 강한 결합(Strong Coupling)** 을 가진 모듈 구조입니다.

> 💬 정리하자면,  
> - 구조적으로는 헥사고날 아키텍처를 따르지만  
> - 런타임 시점에는 여전히 “Order → Member/Product” 로 의존성이 고정되어 있습니다.  
> 따라서 “느슨한 결합형 Modular Monolith”라기보다는  
> **“강한 경계를 가진 단방향 의존 구조(Strong Modular Monolith)”** 에 가깝습니다.

---

## ✅ 현재 구조의 장점

현재 구조는 `Order` 모듈이 `Member`, `Product` 모듈을 **단방향으로 의존**하는 형태로,  
**헥사고날 아키텍처(Hexagonal Architecture)** 와 **의존성 역전(Dependency Inversion Principle, DIP)** 을 부분적으로 적용하고 있습니다.

| 항목 | 설명 |
|------|------|
| **단방향 의존성 (Unidirectional Dependency)** | `Order → Member`, `Order → Product` 로 흐름이 단순하고 명확합니다. 각 모듈이 자신보다 하위 레벨의 모듈만 참조하여, 의존 관계를 예측하기 쉽습니다. |
| **의존성 역전 (Dependency Inversion Principle)** | `OrderServiceImpl`은 `MemberPort`, `ProductPort` 인터페이스에 의존하며, 실제 구현체(`MemberAdapter`, `ProductAdapter`)는 런타임에 주입됩니다. 즉, **상위 모듈이 하위 모듈의 구체 구현에 의존하지 않습니다.** |
| **도메인 독립성 보장 (Domain Isolation)** | Member나 Product 도메인의 내부 로직이 변경되어도, Order 모듈은 Port 인터페이스만 알고 있기 때문에 변경 영향이 거의 없습니다. |
| **테스트 용이성 (Testability)** | Port 인터페이스 기반 구조이므로, Mock 객체를 이용한 단위 테스트 작성이 용이합니다. 각 모듈은 외부 의존성을 독립적으로 검증할 수 있습니다. |
| **유연한 의존 관리 (Adaptability)** | Adapter 교체나 외부 연동 변경 시, 상위 모듈(Order)의 코드는 수정 없이도 재사용 가능합니다. 인터페이스 중심 설계 덕분에, 외부 시스템 변경에도 쉽게 대응할 수 있습니다. |

---

## 💡 요약

현재 구조는 헥사고날 아키텍처의 핵심 원칙인  
- **의존성 역전 (DIP)**  
- **단방향 의존성 유지**  
를 충실히 반영하고 있으며, 도메인 간 결합도를 낮춰 **유지보수성과 테스트 용이성**을 높인 구조입니다.

하지만 완전한 DIP(즉, 의존 방향이 완전히 도메인 중심으로 뒤집히는 형태)는 아닙니다.  
왜냐하면 `Order` 모듈이 `Member`, `Product`의 **UseCase 인터페이스를 직접 호출**하고 있기 때문입니다.  
이 때문에 **실제 의존의 흐름은 여전히 Order → Member/Product 방향**으로 존재합니다.

---

## ⚠️ 하지만... 단점 (실무적으로는 **큰 한계**)

현재 구조는 겉보기엔 깔끔하지만, 실제 서비스 상황에서는 다음과 같은 문제들이 존재합니다.  
이 단점들 때문에 **“단방향 구조만으로는 실용성이 떨어진다”** 고 할 수 있습니다.

### 1. 양방향 통신 불가
- `Member` 모듈이 `Order` 모듈에 접근할 수 없습니다.  
  → 예를 들어, “회원의 주문 내역을 조회”해야 하는 기능을 `Member`에서 구현할 수 없습니다.  
  → 결국 **Order → Member** 단방향 호출만 가능하므로, 반대 방향 흐름은 구현 불가능합니다.
  → 순환 의존 발생 가능

### 2. 도메인 간 상호 작용 한계
- `Product`와 `Member`가 서로 협력해야 하는 상황(예: 구매 이력 기반 추천, 재고 및 포인트 동시 처리 등)에서 **각 도메인이 서로의 내부 UseCase를 호출할 수 없기 때문에 협력 로직을 구현하기 어렵습니다.**

### 3. 비즈니스 복잡도 증가 시 의존 관계가 비대해짐
- Order가 중심이 되어 모든 모듈을 호출하는 구조는, 비즈니스가 커질수록 `OrderServiceImpl`이 **의존성의 허브** 로 변질될 위험이 있습니다.

### 4. 도메인 독립성의 역설
- 각 모듈은 독립적이지만, 결국 모든 흐름이 Order 중심으로 돌아가면서 **실제 독립적인 운영은 불가능한 구조**가 됩니다.

### 5. 확장성 부족
- 예를 들어, **Member → Order** 로 호출이 필요한 새로운 비즈니스 요구가 생기면 기존 단방향 구조를 완전히 뒤집거나, 억지로 이벤트를 붙여야 하는 등 유지보수 비용이 급격히 증가합니다.

---

## 💬 결론

현재 구조는 이론적으로는 깔끔하고 의존성이 명확하지만,  
**실제 운영 환경에서는 도메인 간 협업이 불가능한 “갇힌 구조”** 가 되어버립니다.

즉,  
> ### “Order 중심의 단방향 통신 구조는 처음엔 좋아 보이지만, 도메인 간 상호작용이 필요한 시점이 오면 완전히 막힌다.”

이런 이유로 본 구조는 학습용으로는 적합하지만,  
### **실무 환경에서는 너무 제약적이며, 확장성 면에서 ‘쓰레기 구조’에 가깝다** 고 볼 수 있습니다.

---

## 🚀 다음 단계 (개선 방향)

이 문제를 해결하기 위해 `main` 브랜치에서는  
**중간 통신 모듈(Integration / Shared Application Layer)** 을 추가하여  
도메인 간 **양방향 동기 통신**이 가능하도록 리팩토링했습니다.

→ `main` 브랜치에서 개선된 구조를 확인해주세요!
