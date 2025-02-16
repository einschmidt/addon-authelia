# Home Assistant Add-on: Authelia

## Description

Authelia is an open-source authentication and authorization server designed to provide secure access control for your services. This add-on allows you to run Authelia within Home Assistant.

## Supported Architectures

This add-on supports the following architectures:

- `amd64`
- `aarch64`

## Installation

1. Navigate to **Settings** > **Add-ons** in Home Assistant.
2. Click **Add-on Store** and search for **Authelia**.
3. If necessary, add the `https://github.com/einschmidt/hassio-addons` repository
4. Install the add-on and configure it using the settings below.
5. Start the add-on and open the logs to check for any issues.

## Configuration

The add-on requires a **configuration file (`config.yml`)** to function properly. If one is not found, a **template will be created automatically** during the first startup.

### Example Configuration (`config.yml`):

```yaml
authentication_backend:
  file:
    path: "/config/users.yml"

access_control:
  default_policy: deny
  rules:
    - domain: "example.com"
      policy: one_factor
```

After the first startup, edit the generated file at /config/config.yml with your settings.

The following environment variables are set automatically:

- **`AUTHELIA_SERVER_ADDRESS`** (Default: `tcp://:9091`)

  - The address where Authelia listens.

- **`AUTHELIA_STORAGE_LOCAL_PATH`** (Default: `/data/db.sqlite3`)
  - Path to the local SQLite database.

## First-Time Setup

    •	If no config.yml exists, a default template will be copied to /config/config.yml.
    •	The add-on will exit with an error to prompt you to update the configuration.
    •	After modifying config.yml, restart the add-on.

## More Information

For additional details, visit the official Authelia resources:

- **Website:** [Authelia](https://www.authelia.com//)
- **Documentation:** [Getting Started Guide](https://www.authelia.com/integration/prologue/get-started/)
