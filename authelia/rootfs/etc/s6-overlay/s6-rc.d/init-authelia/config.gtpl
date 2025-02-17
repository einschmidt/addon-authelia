# yamllint disable rule:line-length
---
###############################################################
#                Authelia minimal configuration               #
###############################################################

log:
  level: info

theme: auto

authentication_backend:
  file:
    path: /config/users.yml

session:
  domain: {{ .domain }}
  expiration: 3600  # 1 hour
  inactivity: 300  # 5 minutes
  remember_me_duration: 1y

notifier:
  filesystem:
    filename: /config/emails.txt

access_control:
  default_policy: deny
  rules:
    - domain: "public.{{ .domain }}"
      policy: bypass
    - domain: "secure.{{ .domain }}"
      policy: two_factor

regulation:
    max_retries: 3
    find_time: "2 minutes"
    ban_time: "5 minutes"
...
# yamllint enable rule:line-length
