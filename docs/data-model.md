# Data Model

## Login Attempt
- timestamp
- email
- password

## Voter
- email
- name
- groups (zero or more)

## Group
- name

## Group Voter Association
- voter
- group

## Election
- name
- creator (Voter)
- created-date
- start-date
- end-date
- candidates (zero or more)
- group

## Candidate
- election (parent)
- name
- description

## Ballot
- voter (parent)
- election (parent)
- ranking (Ranking)

## Ranking
- ballot (parent)
- candidate
- rank