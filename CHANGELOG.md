# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- Unified SDK merging all 8 Essabu Java SDKs into a single package
- Shared common infrastructure (HTTP client, auth, retry, exceptions)
- Single entry point via `Essabu.builder()` with lazy module initialization
- Spring Boot auto-configuration with `essabu.*` properties prefix
- Modules: HR, Accounting, Identity, Trade, Payment, E-Invoice, Project, Asset
