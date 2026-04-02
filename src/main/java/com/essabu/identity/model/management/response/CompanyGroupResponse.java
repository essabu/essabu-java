package com.essabu.identity.model.management.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a company group returned by the Essabu Identity API.
 *
 * Contains all company group information returned by the Identity REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the company group resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - description: description
 * - parentCompanyId: parent company id
 * - members: members
 * - createdAt: created at
 * - companyId: company id
 * - companyName: company name
 * - role: role
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyGroupResponse {

    private UUID id;
    private String name;
    private String description;
    private UUID parentCompanyId;
    private List<GroupMember> members;
    private LocalDateTime createdAt;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GroupMember {
        private UUID companyId;
        private String companyName;
        private String role;
    }
}
