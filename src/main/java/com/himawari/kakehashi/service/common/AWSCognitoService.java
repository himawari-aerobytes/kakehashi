package com.himawari.kakehashi.service.common;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AdminCreateUserRequest;
import com.amazonaws.services.cognitoidp.model.AdminGetUserRequest;
import com.amazonaws.services.cognitoidp.model.AdminGetUserResult;
import com.amazonaws.services.cognitoidp.model.AttributeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AWSCognitoService {

    @Value("${AWS_ACCESS_KEY_ID}")
    private String accessKey;

    @Value("${AWS_SECRET_ACCESS_KEY}")
    private String secret;

    @Value("${kakehashi.ap.cognito.userpoolid}")
    private String userPoolId;

    private AWSCredentials credentials;

    private AWSCognitoIdentityProvider userPoolClient;


    public void createLoginUser(String email, String userName, int memberId, int roleId) {
        init();
        final AttributeType memberIdType = new AttributeType();
        final AttributeType emailType = new AttributeType();
        final AttributeType emailVerified = new AttributeType();
        final AttributeType roleIdType = new AttributeType();
        emailType.setName("email");
        emailType.setValue(email);
        memberIdType.setName("custom:member_id");
        memberIdType.setValue(String.valueOf(memberId));
        emailVerified.setName("email_verified");
        emailVerified.setValue("true");
        roleIdType.setName("custom:role_id");
        roleIdType.setValue(String.valueOf(roleId));

        AdminCreateUserRequest adminCreateUserRequest = new AdminCreateUserRequest();
        adminCreateUserRequest
                .withUserPoolId(userPoolId)
                .withUsername(userName)
                .withUserAttributes(emailType, memberIdType, emailVerified);
        this.userPoolClient.adminCreateUser(adminCreateUserRequest);

    }

    /* role_idが追加されたら role_idを使うメソッドを使用すること */
    @Deprecated
    public void createLoginUser(String email, String userName, int memberId) {
        init();
        final AttributeType memberIdType = new AttributeType();
        final AttributeType emailType = new AttributeType();
        final AttributeType emailVerified = new AttributeType();
        emailType.setName("email");
        emailType.setValue(email);
        memberIdType.setName("custom:member_id");
        memberIdType.setValue(String.valueOf(memberId));
        emailVerified.setName("email_verified");
        emailVerified.setValue("true");


        AdminCreateUserRequest adminCreateUserRequest = new AdminCreateUserRequest();
        adminCreateUserRequest
                .withUserPoolId(userPoolId)
                .withUsername(email)
                .withUserAttributes(emailType, memberIdType, emailVerified);
        this.userPoolClient.adminCreateUser(adminCreateUserRequest);

    }

    public Map<String, String> getUserInfo(String email) {
        init();
        AdminGetUserResult adminGetUserResult = userPoolClient.adminGetUser(
                new AdminGetUserRequest().withUserPoolId(userPoolId)
                        .withUsername(email));

        return adminGetUserResult.getUserAttributes().stream().collect(Collectors.toMap(s -> s.getName(), s -> s.getValue()));


    }

    private void init() {
        if (credentials == null || userPoolClient == null) {
            credentials = new BasicAWSCredentials(this.accessKey, this.secret);
            userPoolClient = AWSCognitoIdentityProviderClientBuilder
                    .standard()
                    .withCredentials(new AWSStaticCredentialsProvider(this.credentials))
                    .withRegion(Regions.AP_NORTHEAST_1)
                    .build();

        }

    }
}
