CREATE TABLE ERS_USERS (
        u_id integer primary key,
        u_username varchar2(40) NOT NULL,
        u_password varchar2(40) NOT NULL,
        u_firstname varchar2(30),
        u_lastname varchar2(30),
        u_email varchar2(100),
        ur_id integer NOT NULL,
CONSTRAINT user_constraint UNIQUE (u_username, u_email)
);

CREATE TABLE ERS_USER_ROLES (
        ur_id integer primary key,
        ur_role varchar2(40)
);

ALTER TABLE ERS_USERS
ADD CONSTRAINT fk_user_role
FOREIGN KEY (ur_id) REFERENCES ERS_USER_ROLES(ur_id)
ON DELETE CASCADE;

CREATE TABLE ERS_REIMBURSEMENTS (
        r_id integer primary key,
        r_amount number(22,2) NOT NULL,
        r_description varchar2(100),
        r_receipt blob,
        r_sumbmitted timestamp NOT NULL,
        r_resolved timestamp,
        u_id_author integer NOT NULL,
        u_id_resolver integer,
        r_type_id integer NOT NULL,
        r_status_id integer NOT NULL
);

CREATE TABLE ERS_REIMBURSEMENT_STATUS (
        rs_id integer primary key,
        rs_status varchar2(30) NOT NULL
);

CREATE TABLE ERS_REIMBURSEMENT_TYPE (
        rt_id integer primary key,
        rt_type varchar2(30) NOT NULL
);

ALTER TABLE ERS_REIMBURSEMENTS
ADD CONSTRAINT fk_u_id_author
FOREIGN KEY (u_id_author) REFERENCES ERS_USERS(u_id)
ON DELETE CASCADE;

ALTER TABLE ERS_REIMBURSEMENTS
ADD CONSTRAINT fk_u_id_resolver
FOREIGN KEY (u_id_resolver) REFERENCES ERS_USERS(u_id)
ON DELETE CASCADE;

ALTER TABLE ERS_REIMBURSEMENTS
ADD CONSTRAINT fk_r_type_id
FOREIGN KEY (r_type_id) REFERENCES ERS_REIMBURSEMENT_TYPE(rt_id)
ON DELETE CASCADE;

ALTER TABLE ERS_REIMBURSEMENTS
ADD CONSTRAINT fk_r_status_id
FOREIGN KEY (r_status_id) REFERENCES ERS_REIMBURSEMENT_STATUS(rs_id)
ON DELETE CASCADE;