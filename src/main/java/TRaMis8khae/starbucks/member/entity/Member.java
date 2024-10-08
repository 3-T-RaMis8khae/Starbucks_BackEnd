package TRaMis8khae.starbucks.member.entity;

import TRaMis8khae.starbucks.common.utils.CodeGenerator;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Entity
@NoArgsConstructor
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 36)
    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String loginId;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(length = 50)
    private Date birth;

    @Column(length = 50)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(length = 50)
    private String nickname;

    @Column(length = 100)
    private String address;

    @Column(length = 50)
    private String memberMaskingId;

    @Column(length = 6)
    private String paymentPassword;

    private Boolean memberStatus;

    @Builder
    public Member(Long id,
                  String memberUUID,
                  String name,
                  String loginId,
                  String password,
                  Date birth,
                  String phoneNumber,
                  String email,
                  String nickname,
                  String address,
                  String paymentPassword,
                  Boolean memberStatus,
                  String memberMaskingId,
                  Boolean marketingConsentEmail,
                  Boolean marketingConsentSms
    ) {
        this.id = id;
        this.memberUUID = memberUUID;
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nickname = nickname;
        this.address = address;
        this.memberMaskingId = memberMaskingId;
        this.paymentPassword = paymentPassword;
        this.memberStatus = memberStatus;
    }

    // memberUUID 값이 없을 경우 자동으로 생성
    @PrePersist
    public void prePersist() {
        this.memberUUID = CodeGenerator.generateCode(36);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> authorities = new ArrayList<>();
        return List.of();
    }

    @Override
    public String getUsername() {
        return memberUUID;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}